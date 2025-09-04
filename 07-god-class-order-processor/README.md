# 07 — God Class: Order Processor (Group)
**Motivation:** A do-everything method is untestable and brittle. Split into cohesive services and invert dependencies.

## Scenario
Business wants to introduce promo codes and loyalty points. The OrderProcessor already calculates discounts, tax, persistence, notifications, payments all in one.

## Risk 
Adding promo code logic into the God method will make it unmaintainable.

## Lesson 
Split responsibilities (Pricing, Payment, Repo, Notifier) before adding new pricing features.

## Steps
1) Identify responsibilities: pricing, discounts, tax, shipping, persistence, payments, notifications.
2) Define ports (`Pricing`, `OrderRepository`, `Notifier`, `PaymentGateway`, `Clock`).
3) Extract collaborators and inject via constructor. Keep `OrderService` thin.
4) Write tests with fakes; then improve pricing rules safely.
