package parser.stax;

import model.Seed;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeedParserMain
{

    public static void main(String[] args)
    {

        try
        {
            String xml = "InfoSeed.xml";
            XMLInputFactory factory = XMLInputFactory.newFactory();
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(xml));
            List<Seed> seeds = new ArrayList<>();
            Seed temp = null;
            Map<String, Boolean> flag = new HashMap<>();

            flag.put("SEED", false);
            flag.put("ID", false);
            flag.put("NAME", false);
            flag.put("CODE", false);
            flag.put("HIBRID_NAME", false);
            flag.put("PATENT_NUMBER", false);
            flag.put("START_DATE", false);
            flag.put("PATENT_OWNER", false);
            flag.put("END_DATE", false);
            flag.put("START_REGISTER_DATE", false);

            while (reader.hasNext())
            {
                int eventType = reader.getEventType();
                if (eventType == XMLStreamConstants.START_ELEMENT)
                {
                    flag.put(reader.getLocalName(), true);
                    if (reader.getLocalName().equals("SEED")) temp = new Seed();
                }
                else if (eventType == XMLStreamConstants.CHARACTERS)
                {
                    String data = reader.getText();
                    if (flag.get("SEED"))
                    {
                        if (flag.get("ID")) temp.setId(Long.parseLong(data));
                        else if (flag.get("NAME")) temp.setName(data);
                        else if (flag.get("CODE")) temp.setCode(new BigDecimal(data));
                        else if (flag.get("HIBRID_NAME")) temp.setHibridName(data);
                        else if (flag.get("PATENT_NUMBER")) temp.setPatentNumber(data);
                        else if (flag.get("START_DATE")) temp.setStartDate(LocalDate.parse(data));
                        else if (flag.get("PATENT_OWNER")) temp.setPatentOwner(data);
                        else if (flag.get("END_DATE")) temp.setEndDate(LocalDate.parse(data));
                        else if (flag.get("START_REGISTER_DATE")) temp.setStartRegisterDate(Long.parseLong(data));
                    }
                    else
                    {
                        if (flag.get("ID")) Seed.setHeaderId(data);
                        else if (flag.get("NAME")) Seed.setHeaderName(data);
                        else if (flag.get("CODE")) Seed.setHeaderCode(data);
                        else if (flag.get("HIBRID_NAME")) Seed.setHeaderHibridName(data);
                        else if (flag.get("PATENT_NUMBER")) Seed.setHeaderPatentNumber(data);
                        else if (flag.get("START_DATE")) Seed.setHeaderStartDate(data);
                        else if (flag.get("PATENT_OWNER")) Seed.setHeaderPatentOwner(data);
                        else if (flag.get("END_DATE")) Seed.setHeaderEndDate(data);
                        else if (flag.get("START_REGISTER_DATE")) Seed.setHeaderStartRegisterDate(data);
                    }
                }
                else if (eventType == XMLStreamConstants.END_ELEMENT)
                {
                    if (reader.getLocalName().equals("SEED"))
                    {
                        seeds.add(temp);
                        temp = null;
                    }
                    flag.put(reader.getLocalName(), false);
                }
                reader.next();
            }

            seeds.forEach(System.out::print);

        } catch (XMLStreamException | FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
