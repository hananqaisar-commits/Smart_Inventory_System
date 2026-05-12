package com.NexStock.model;

@FunctionalInterface
interface DiscountStrategy {

    double applydiscount(double grandTotal);

}