import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import static org.elasticsearch.node.NodeBuilder.*;

public class ElasticSearchDemo {
	public static void main(String[] args) {
		Node node = nodeBuilder()
				  .clusterName("elasticsearch").client(true).node();
				Client client = node.client();
	}
}
