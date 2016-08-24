package org.twtpush.dto.Broker;

/**
 * Created by nero on 16-8-22.
 */
public class Connection {
    private Long id;
    private String label;

    public Connection() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }
}
