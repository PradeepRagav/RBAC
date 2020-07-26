package model;

import java.util.List;
import java.util.Map;

public class ResourceNode {
    private Integer id;
    //UserId to Role Map
    private Map<Integer,Integer> userId;
    private List<ResourceNode> childResorces;

    public ResourceNode(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map<Integer, Integer> getUserId() {
        return userId;
    }

    public void setUserId(Map<Integer, Integer> userId) {
        this.userId = userId;
    }

    public List<ResourceNode> getChildResorces() {
        return childResorces;
    }

    public void setChildResorces(List<ResourceNode> childResorces) {
        this.childResorces = childResorces;
    }

    @Override public String toString() {
        return "ResourceNode{" + "id=" + id + ", userId=" + userId + ", childResorces=" + childResorces + '}';
    }
}
