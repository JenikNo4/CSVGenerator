package com.coleman;


import static net.andreinc.mockneat.types.enums.CreditCardType.AMERICAN_EXPRESS;
import static net.andreinc.mockneat.types.enums.CreditCardType.VISA_16;
import static net.andreinc.mockneat.types.enums.DomainSuffixType.POPULAR;
import static net.andreinc.mockneat.types.enums.IPv4Type.CLASS_B;
import static net.andreinc.mockneat.types.enums.IPv4Type.CLASS_C_NONPRIVATE;
import static net.andreinc.mockneat.unit.financial.CreditCards.creditCards;
import static net.andreinc.mockneat.unit.networking.IPv4s.ipv4s;
import static net.andreinc.mockneat.unit.networking.URLs.urls;
import static net.andreinc.mockneat.unit.regex.Regex.regex;
import static net.andreinc.mockneat.unit.text.CSVs.csvs;
import static net.andreinc.mockneat.unit.text.Strings.strings;
import static net.andreinc.mockneat.unit.time.LocalDates.localDates;
import static net.andreinc.mockneat.unit.types.Doubles.doubles;
import static net.andreinc.mockneat.unit.types.Ints.ints;
import static net.andreinc.mockneat.unit.user.Emails.emails;
import static net.andreinc.mockneat.unit.user.Names.names;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Integer rows = 1000;
        if (args.length != 0){
            rows = Integer.parseInt(args[0]);
        }
        csvs()
                .column(names().first())
                .column(names().last())
                .column(emails().domain("mockneat.com"))
                .column(urls().domains(POPULAR))
                .column(ipv4s().types(CLASS_B, CLASS_C_NONPRIVATE))
                .column(creditCards().types(AMERICAN_EXPRESS, VISA_16))
                .column(localDates().thisYear())
                .column(doubles())
                .column(ints())
                .column(strings())
                .column(regex("\\d{3} \\s{6} \\d{4}"))
                .separator(", ")
//                .accumulate(25, "\n")
                .write("filename1.csv", rows);
//                .consume(System.out::println);

    }
}
