package ua.lviv.lgs;

public class Pet {

	private int id;
	private String name;
	private String kind;
	private int owner_id;
	
	public Pet(String name, String kind, int owner_id) {
		super();
		this.name = name;
		this.kind = kind;
		this.owner_id = owner_id;
	}

	public Pet(int id, String name, String kind, int owner_id) {
		super();
		this.id = id;
		this.name = name;
		this.kind = kind;
		this.owner_id = owner_id;
	}

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

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", kind=" + kind + ", owner_id=" + owner_id + "]";
	}	
	
}
