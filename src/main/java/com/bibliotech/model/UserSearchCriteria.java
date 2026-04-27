package com.bibliotech.model;

public record UserSearchCriteria(
    String dni,
    String name,
    Class<? extends Member> type
) {}
