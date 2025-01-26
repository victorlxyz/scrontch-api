package xyz.victorl.scrontch.users.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class UserCreatedEvent extends ApplicationEvent {
    private final Integer userId;

    public UserCreatedEvent(Object source, Integer userId) {
        super(source);
        this.userId = userId;
    }
}