package parser.sax;

import model.Seed;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeedSaxHandler extends DefaultHandler
{
    private List<Seed> seeds;
    private Seed temp;
    private static Map<String, Boolean> flag = new HashMap<>();

    static
    {
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
    }

    public List<Seed> getSeeds()
    {
        return seeds;
    }

    public SeedSaxHandler()
    {
        super();
    }

    @Override
    public void startDocument() throws SAXException
    {
        seeds = new ArrayList<>();
    }

    @Override
    public void endDocument() throws SAXException
    {
        System.out.println(seeds);
       /* System.out.println(Seed.getHeaderId());
        System.out.println(Seed.getHeaderName());
        System.out.println(Seed.getHeaderCode());
        System.out.println(Seed.getHeaderHibridName());
        System.out.println(Seed.getHeaderPatentNumber());
        System.out.println(Seed.getHeaderStartDate());
        System.out.println(Seed.getHeaderPatentOwner());
        System.out.println(Seed.getHeaderEndDate());
        System.out.println(Seed.getHeaderStartRegisterDate());
        */
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        if (qName.equals("SEED")) temp = new Seed();
        flag.put(qName, true);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        String data = new String(ch, start, length);

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

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        if (qName.equals("SEED"))
        {
            seeds.add(temp);
            temp = null;
        }

        flag.put(qName, false);
    }
}
