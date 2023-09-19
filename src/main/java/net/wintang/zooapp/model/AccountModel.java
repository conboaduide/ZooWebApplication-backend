package net.wintang.zooapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.wintang.zooapp.entity.Account;

@Data
@NoArgsConstructor
public class AccountModel {
    private Long id;
    private String username;
    private String role;

    public AccountModel(Account account) {
        this.id = account.getId();
        this.username = account.getUsername();
        this.role = account.getRole();
    }
}
