package br.com.jpdev01.asaassdk.rest.pix.enums;

public enum PixTransactionStatus {

    AWAITING_BALANCE_VALIDATION,
    AWAITING_CRITICAL_ACTION_AUTHORIZATION,
    AWAITING_EXTERNAL_AUTHORIZATION,
    AWAITING_CHECKOUT_RISK_ANALYSIS_REQUEST,
    SCHEDULED,
    AWAITING_REQUEST,
    REQUESTED,
    DONE,
    REFUSED,
    ERROR,
    CANCELLED
}