import com.gosecuri.Agent;
import com.gosecuri.GenerationListeAgents;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class GenerationListeAgentsTest {

    private GenerationListeAgents generationListeAgents;

    @Before
    public void beforeClass() throws IOException {
        List<Agent> agentList = new ArrayList<>();
        List<String> materiel = new ArrayList<>();
        materiel.add("menottes");
        materiel.add("cyno");
        materiel.add("lacrymo");
        agentList.add(new Agent("Foley", "Angelo", "Surveillance entrepôt", "2Fk5YBG4we85g", materiel, "img/agents_jpg/afoley.jpg"));
        this.generationListeAgents = new GenerationListeAgents(agentList);
    }

    @Test
    public void HTMLIndexGenerationTest() throws IOException {
        this.generationListeAgents.HTMLIndexGeneration();
        File fileIndex = new File("../web/index.html");
        StringBuilder fileContent = new StringBuilder();
        if (fileIndex.exists() && !fileIndex.isDirectory()) {
            Scanner scanner = new Scanner(fileIndex);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                fileContent.append(line);
            }
        }
        assertThat(fileContent.toString(), containsString("Angelo Foley"));
    }

}
