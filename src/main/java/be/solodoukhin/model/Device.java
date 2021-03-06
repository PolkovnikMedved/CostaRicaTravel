package be.solodoukhin.model;

import javax.persistence.*;

@Entity
@Table(name = "ios_id")
public class Device {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "token")
    private String token;

    public Device() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", token='" + token + '\'' +
                '}';
    }
}
