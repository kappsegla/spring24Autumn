package org.example.spring24.todo;

import java.io.Serializable;

public record Todo(long userId, long id, String title, boolean completed) implements Serializable {}
