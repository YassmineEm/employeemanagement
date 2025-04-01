package com.example.employeemanagement.enums;

public enum RoleEnum {
    ADMIN,
    MANAGER,
    EMPLOYEE;

    public static RoleEnum fromString(String role) {
        switch (role.toUpperCase()) {
            case "ADMIN":
                return ADMIN;
            case "MANAGER":
                return MANAGER;
            case "EMPLOYEE":
                return EMPLOYEE;
            default:
                throw new IllegalArgumentException("Unknown role: " + role);
        }
    }
}
