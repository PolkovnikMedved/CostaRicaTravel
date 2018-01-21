package be.solodoukhin.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "hot_word")
public class HotWord {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "fk_partner_id")
    @JsonBackReference
    private Partner partner;

    public HotWord() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    @Override
    public String toString() {
        return "HotWord{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", partner=" + partner +
                '}';
    }
}
