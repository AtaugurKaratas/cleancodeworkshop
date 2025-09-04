# 05 — Replace Switch with Polymorphism (DIP/OCP)
**Motivation:** Type-code switches are open invitations to bugs when adding new behaviors. Encapsulate variations in strategies.

## Story
The product team has requested a new WhatsApp notification channel.

## Risk
The current service uses a giant if/else switch statement for notification types. Adding another branch increases duplication and fragility.

## Refactoring Goal
Refactor into a strategy pattern with a Notifier interface and channel-specific implementations.

## Steps
1) Define a Notifier interface.
2) Create individual classes for each notification type.
3) Replace the switch logic with a strategy map.
4) Add unit tests for each notifier.
5) Implement WhatsApp support as a new class.