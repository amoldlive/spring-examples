package com.reactive.entity;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Person {
    int id;
    String firstName;
    String lastName;
}
