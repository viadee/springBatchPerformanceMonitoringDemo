package de.viadee.sbpm.demo.job;

public class DemoItem {

	private Integer partition;

	private Integer id;

	private String name;

	public DemoItem(Integer partition, Integer id, String name) {
		this.partition = partition;
		this.id = id;
		this.name = name;
	}

	public boolean between(Integer fromId, Integer toId) {
		boolean from = this.id.compareTo(fromId) > 0;
		boolean to = this.id.compareTo(toId) < 0;
		return from && to;
	}

	@Override
	public String toString() {
		return getName();
	}

	public Integer getPartition() {
		return partition;
	}

	public void setPartition(Integer partition) {
		this.partition = partition;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
