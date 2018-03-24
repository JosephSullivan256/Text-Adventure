package com.josephsullivan256.gmail.tba;

import java.util.List;

public interface Node {
	public void provide(CommandConsumer c, RelationType rt);
	public void addChild(Node n);
	public boolean removeChild(Node n);
	public List<Node> getChildren();
	public void dissociate(Node n);
	public void associate(Node n, RelationType rt);
}
