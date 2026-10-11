---
id: admin-assign-pickup-point-staff
title: Admin endpoint to assign pickup-point staff (first manager) — activation is blocked without it
author: frontend
to: backend
status: closed
priority: high
area: logistics
created: 2026-10-12
closed: 2026-10-12
reply_to:
---

## What

Add `POST /admin/pickup-points/{id}/staff` so a platform admin can assign a user
as staff of a pickup point — in particular the **first manager**.

Today there is no way to do this from the API:

- `PATCH /admin/pickup-points/{id}/status` → `active` returns `400` while the
  point has no active manager.
- Managers can only invite people who are already staff
  (`POST /pickup-staff/staff/invite`), so the first manager can't come from there.
- `docs/logistics-and-pickup-points-api.md` §2.1 admits the first manager has to
  be created "some other way today (direct DB/seed)". The admin panel's staff
  dialog is read-only because of this, so **no pickup point can be activated
  from the UI**.

### Spec (from the PM's update of Doc 05)

**§2.2 PickupPointStaff — new rules**

- **One point at a time:** a user can be active staff at only one pickup point.
  Assigning someone who is already active staff elsewhere returns `409`.
- **Bootstrapping the first manager:** managers can only invite people who are
  already staff, and a point can't be activated without a manager. So the first
  manager must be assigned by a platform admin via
  `POST /admin/pickup-points/{id}/staff`. After that, managers invite their own
  operators through `/pickup-staff/staff/invite`.
- **Last-manager protection:** nobody can suspend or remove the last active
  manager of an active point. Reject it, or require the point to be set to
  `temporarily_closed` first.

**`PickupPointStaffService`**

- `invite_staff(point_id, user_id, role, actor)`: actor can be a platform admin
  (any point, any role, including the first manager) or a manager of that same
  point. Enforces the one-point rule; admin calls are written to `AuditLog`.
- `update_role(staff_id, role, actor)`
- `suspend_staff(staff_id, actor)`: enforces last-manager protection.

**§6.1 Admin endpoints — new rows**

| Method | Path | Purpose |
|---|---|---|
| POST | `/admin/pickup-points/{id}/staff` | body `{ user_id, role }`. Assigns staff, and is how the first manager is created. `409` if the user is already active staff at another point. |
| PATCH | `/admin/pickup-points/{id}/staff/{staff_id}` | body `{ role?, status? }`. Changes a role or suspends staff. Can come later; not needed to unblock activation. |

### Priority

Only the **POST** is needed now to unblock activation. The PATCH and
last-manager protection can follow.

### Frontend needs (to build the "Add staff" form)

- The POST takes a `user_id`, so the admin panel needs a way to find the user.
  If `GET /admin/users` (with search) already covers that, no change is needed;
  otherwise please say what to use.
- Response: the created `PickupPointStaffRead` (same shape as the list).
- Error responses with `detail` (and a stable `code` per
  `localized-error-messages`), at least: user not found, user already active
  staff elsewhere (`409`), point not found.

## Why

Without it the whole logistics flow is stuck at "pending_setup": a point can't
be activated, so it can't be chosen at checkout or receive shipments.

## References

docs/logistics-and-pickup-points-api.md §2.1 and §2.2;
openapi/api.yaml → `/api/v1/admin/pickup-points/{point_id}/staff` (GET only today);
tasks: `localized-error-messages`

## Resolution

Done (backend, 2026-10-12) for the part that unblocks activation.

- `POST /admin/pickup-points/{id}/staff` — body `{ user_id, role }`, `201 PickupPointStaffRead`,
  permission `logistics:manage`. Any role, any point; written to `AuditLog`
  (`pickup_point.staff_assigned`). Verified: assign → `PATCH …/status` `active` succeeds.
- Errors, each `{ detail, code }` in the request's `Accept-Language`:
  `404 pickup_point.not_found`, `404 pickup_staff.user_not_found`,
  `400 pickup_staff.user_inactive`, `409 pickup_staff.already_active`.
- One point per user is also enforced for `POST /pickup-staff/staff/invite`, which now returns
  `409` (was `400`) with the same code.
- **Finding the user:** `GET /users/?search=` (new, email or full name contains, ordered by id;
  needs `users:read`, which `admin` and `root` have).
- Follow-up, same day: `PATCH /admin/pickup-points/{id}/staff/{staff_id}` with `{ role?, status? }`
  (at least one; `status: "suspended"` / `"active"`), and last-manager protection —
  `400 pickup_staff.last_manager` when suspending or demoting the last active manager of an
  **active** point, for the admin PATCH and the manager's own `PATCH /pickup-staff/staff/{id}/role`
  and `/suspend`. Also `404 pickup_staff.not_found`, and `409 pickup_staff.already_active` on
  reactivation. Audited as `pickup_point.staff_updated`.
