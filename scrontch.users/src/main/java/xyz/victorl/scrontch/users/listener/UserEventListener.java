package xyz.victorl.scrontch.users.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.users.event.UserCreatedEvent;
import xyz.victorl.scrontch.common.entity.Shoppinglist;
import xyz.victorl.scrontch.common.repository.ShoppinglistRepository;

@Component
public class UserEventListener {

    @Autowired
    private ShoppinglistRepository shoppinglistRepository;

    @EventListener
    @Transactional
    public void handleUserCreatedEvent(UserCreatedEvent event) {
        Shoppinglist defaultList = new Shoppinglist();
        defaultList.setUserid(event.getUserId());
        defaultList.setName(Shoppinglist.DEFAULT_LIST_NAME);
        shoppinglistRepository.save(defaultList);
    }
}