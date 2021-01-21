package thisKeyword;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//             Root
//          /         \
//       a1            a2
//      /  \          /  \
//    b1   dead       c1    c2
//   / \     \
//d1    d2    d3
/* 
  mi.birth("Root");
  mi.birth("a1","Root");
  mi.birth("a2","Root");
  mi.birth("b1","a1");
  ...
*/

class Node {
  private String name;
  private List<Node> childs;
  private boolean isDead;

  Node(String name) {
    this.name = name;
    this.childs = new ArrayList<>();
    this.isDead = false;
  }

  public List<Node> getChilds() {
    return this.childs;
  }

  public boolean isDead() {
    return this.isDead;
  }

  public void kill() {
    this.isDead = true;
  }

  public String getName() {
    return this.name;
  }
}

interface Monarchy {
  void birth(String child, String parent);

  void death(String name);

  // if a person dies, they are removed from monarchy but their children are still
  // considered monarchs
  List<String> getOrderOfSuccession();
}

class MonarchyImpl implements Monarchy {

  private Map<String,Node> map;
  private Node king;

  public MonarchyImpl() {
    this.map = new HashMap<>();
  }

  public void birth(String child, String parent) {
    Node parentNode;

    if (parent == null) {
      this.king = new Node(child);
      map.put(child, this.king);
    } else {
      if (map.containsKey(parent)) {
        parentNode = map.get(parent);
      } else {
        parentNode = new Node(parent);
        map.put(parent, parentNode);
      }
      Node childNode = new Node(child);
      parentNode.getChilds().add(childNode);
      map.put(child, childNode);
    }
  }

  public void death(String name) {
    if (map.containsKey(name)) {
      Node node = map.get(name);
      node.kill();
    }
  }

  // if a person dies, they are removed from monarchy but their children are still
  // considered monarchs
  public List<String> getOrderOfSuccession() {
    List<String> successors = new ArrayList<>();
    if (king != null) {
      getSuccessors(king, successors);
    }
    return successors;
  }

  private void getSuccessors(Node child, List<String> successors) {
    if (child != null) {
      if (!child.isDead()) {
        successors.add(child.getName());
      }
      child.getChilds().stream().map(node -> this.map.get(node.getName())).forEach(m -> getSuccessors(m, successors));
    }
  }

  public Map<String,Node> getData() {
    return this.map;
  }
}

public class MonarchyMain {
  public static void main(String[] args) {
    Monarchy monarchy = new MonarchyImpl();
    monarchy.birth("king", null);
    monarchy.birth("Jean", "king");
    monarchy.birth("Trump", "Jean");
    monarchy.birth("Biden", "Jean");
    monarchy.birth("Tim", "Trump");
    monarchy.birth("Emma", "Trump");
    monarchy.death("king");
    monarchy.death("Jean");
    monarchy.death("Trump");
    monarchy.birth("Philippe", "Jean");

    System.out.println(monarchy.getOrderOfSuccession());
    // Order of Succession:
    // Root -> a1 -> b1 -> d1 -> d2 -> b2 -> d3 -> a2 -> c1 -> c2
  }
}
