DROP SCHEMA IF EXISTS payment CASCADE;

CREATE SCHEMA payment;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TYPE IF EXISTS payment_status;

CREATE TYPE payment_status as ENUM ('COMPLETED', 'CANCELLED', 'FAILED');

CREATE TABLE "payment".payments
(
    id          uuid                     not null,
    customer_id uuid                     not null,
    order_id    uuid                     not null,
    price       numeric(10, 2)           not null,
    created_at  timestamp with time zone not null,
    status      payment_status           not null,
    constraint payments_pkey primary key (id)
);

drop type if exists transaction_type;

create type transaction_type as enum ('DEBIT', 'CREDIT');

drop table if exists "payment".credit_history cascade;
create table "payment".credit_history
(
    id          uuid             not null,
    customer_id uuid             not null,
    amount      numeric(10, 2)   not null,
    type        transaction_type not null,
    constraint credit_history_pkey primary key (id)
);

