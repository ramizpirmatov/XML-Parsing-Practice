package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Seed
{
    private long id;
    private String name;
    private BigDecimal code;
    private String hibridName;
    private String patentNumber;
    private LocalDate startDate;
    private String patentOwner;
    private LocalDate endDate;
    private Long startRegisterDate;

    static private String headerId;
    static private String headerName;
    static private String headerCode;
    static private String headerHibridName;
    static private String headerPatentNumber;
    static private String headerStartDate;
    static private String headerPatentOwner;
    static private String headerEndDate;
    static private String headerStartRegisterDate;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public BigDecimal getCode()
    {
        return code;
    }

    public void setCode(BigDecimal code)
    {
        this.code = code;
    }

    public String getHibridName()
    {
        return hibridName;
    }

    public void setHibridName(String hibridName)
    {
        this.hibridName = hibridName;
    }

    public String getPatentNumber()
    {
        return patentNumber;
    }

    public void setPatentNumber(String patentNumber)
    {
        this.patentNumber = patentNumber;
    }

    public LocalDate getStartDate()
    {
        return startDate;
    }

    public void setStartDate(LocalDate startDate)
    {
        this.startDate = startDate;
    }

    public String getPatentOwner()
    {
        return patentOwner;
    }

    public void setPatentOwner(String patentOwner)
    {
        this.patentOwner = patentOwner;
    }

    public LocalDate getEndDate()
    {
        return endDate;
    }

    public void setEndDate(LocalDate endDate)
    {
        this.endDate = endDate;
    }

    public Long getStartRegisterDate()
    {
        return startRegisterDate;
    }

    public void setStartRegisterDate(Long startRegisterDate)
    {
        this.startRegisterDate = startRegisterDate;
    }

    public static String getHeaderId()
    {
        return headerId;
    }

    public static void setHeaderId(String headerId)
    {
        Seed.headerId = headerId;
    }

    public static String getHeaderName()
    {
        return headerName;
    }

    public static void setHeaderName(String headerName)
    {
        Seed.headerName = headerName;
    }

    public static String getHeaderCode()
    {
        return headerCode;
    }

    public static void setHeaderCode(String headerCode)
    {
        Seed.headerCode = headerCode;
    }

    public static String getHeaderHibridName()
    {
        return headerHibridName;
    }

    public static void setHeaderHibridName(String headerHibridName)
    {
        Seed.headerHibridName = headerHibridName;
    }

    public static String getHeaderPatentNumber()
    {
        return headerPatentNumber;
    }

    public static void setHeaderPatentNumber(String headerPatentNumber)
    {
        Seed.headerPatentNumber = headerPatentNumber;
    }

    public static String getHeaderStartDate()
    {
        return headerStartDate;
    }

    public static void setHeaderStartDate(String headerStartDate)
    {
        Seed.headerStartDate = headerStartDate;
    }

    public static String getHeaderPatentOwner()
    {
        return headerPatentOwner;
    }

    public static void setHeaderPatentOwner(String headerPatentOwner)
    {
        Seed.headerPatentOwner = headerPatentOwner;
    }

    public static String getHeaderEndDate()
    {
        return headerEndDate;
    }

    public static void setHeaderEndDate(String headerEndDate)
    {
        Seed.headerEndDate = headerEndDate;
    }

    public static String getHeaderStartRegisterDate()
    {
        return headerStartRegisterDate;
    }

    public static void setHeaderStartRegisterDate(String headerStartRegisterDate)
    {
        Seed.headerStartRegisterDate = headerStartRegisterDate;
    }

    @Override
    public String toString()
    {
        return "Seed{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", hibridName='" + hibridName + '\'' +
                ", patentNumber='" + patentNumber + '\'' +
                ", startDate=" + startDate +
                ", patentOwner='" + patentOwner + '\'' +
                ", endDate=" + endDate +
                ", startRegisterDate=" + startRegisterDate +
                "}\n";
    }
}
