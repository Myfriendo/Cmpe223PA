package question1;

public class Route {
	private String source,destination;
	
	public Route(String source, String destination) {
		// TODO Auto-generated constructor stub
		this.source = source;
		this.destination = destination;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
// comparing lexographical order of source if its equals to previous one than looks to destination's lexographical order
	public int compareTo(Route that) {
		// TODO Auto-generated method stub
		int num=this.source.compareTo(that.source);
		if (num != 0) return num;
		else return this.destination.compareTo(that.destination);
	}
		



}
