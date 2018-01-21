package be.solodoukhin.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "crt_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private boolean enabled = false;

    //TODO Update DML
    private LocalDate createdAt;
    private LocalDate enabledAt;
    private String enabledBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getEnabledAt() {
        return enabledAt;
    }

    public void setEnabledAt(LocalDate enabledAt) {
        this.enabledAt = enabledAt;
    }

    public String getEnabledBy() {
        return enabledBy;
    }

    public void setEnabledBy(String enabledBy) {
        this.enabledBy = enabledBy;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", createdAt=" + createdAt +
                ", enabledAt=" + enabledAt +
                ", enabledBy='" + enabledBy + '\'' +
                '}';
    }
}
