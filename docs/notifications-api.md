# Push Notifications API — Mobile Integration Guide

Device tokens and the events that send a push to a buyer. All paths are relative to
the API base (`/api/v1`). Schemas: `openapi/api.yaml` → `DeviceRegisterRequest`, `DeviceRead`.

> **Delivery status.** Registration and the events below are live, and each event builds the
> localized message and its payload. The backend's push sender currently only **logs** the
> message (`PUSH_BACKEND=console`); real delivery to Android and iOS (FCM) is not wired up
> yet because it needs credentials and a provider library. Build and test the app's side
> now; pushes start arriving once the backend ships its provider. Nothing in this guide
> changes when that happens.

## Device tokens

| Method | Path | Notes |
|---|---|---|
| PUT | `/devices` | `{ token, platform: "android" \| "ios", locale?: "uz" \| "ru" \| "en" }` → `DeviceRead`. Register or refresh this phone for the logged-in user. Call it after login, and again whenever the token or the app language changes. A token already registered to another account **moves** to this one, so a shared phone only ever notifies the newest login |
| DELETE | `/devices?token=...` | `204`. Stop pushes to this phone for the logged-in user. Call it **before** `POST /auth/logout`. Unknown tokens, and tokens of another user, are ignored (`204` either way) |

Both need login. `locale` picks the text language; without it the text is Uzbek.
The token is the FCM registration token (Android) or the APNs-backed FCM token (iOS).

## Events

Every push has a localized `title` and `body` and a `data` map of strings. Open the
matching screen from `data.type`:

| `data.type` | Sent when | Other `data` keys | Open |
|---|---|---|---|
| `order_group.arrived_at_point` | A shop's group was checked in at the buyer's pickup point and is ready to collect | `order_id`, `group_id`, `collection_deadline` (ISO, UTC) | The order; `GET /orders/{order_id}/groups/{group_id}/pickup-status` has the same deadline. The text shows it in Uzbekistan time (UTC+5) |
| `order_group.cancelled` | A shop or an admin cancelled a group. **Not** sent for a cancellation the buyer made themselves | `order_id`, `group_id` | The order |
| `refund.approved` | A return request was approved (by the seller, or by an admin after an escalation) | `order_id`, `group_id`, `refund_request_id` | The order; if the line is `return_pending`, show where to bring the item (`refund_request.return_point`) |
| `refund.rejected` | A return request was rejected (by the seller, or finally by an admin) | `order_id`, `group_id`, `refund_request_id` | The order, showing `refund_request.resolution_note` and, if allowed, "escalate" |

Only requests the buyer made themselves send a refund push. All values in `data` are strings
(`order_id: "12"`).

## Not covered yet

- Real delivery (see the note at the top).
- No push for the collection-deadline reminder, for `shipped`, or for other group statuses;
  the app still polls for those.
- No opt-out per event type; the user can only disable notifications in the OS.
- Invalid or expired tokens are not cleaned up automatically yet. Unregister on logout.
