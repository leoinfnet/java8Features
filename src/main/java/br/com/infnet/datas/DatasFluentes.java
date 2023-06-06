package br.com.infnet.datas;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Locale;

public class DatasFluentes {
    public static void main(String[] args) {
        Calendar mesQueVem = Calendar.getInstance();
        mesQueVem.add(Calendar.MONTH, 1);

        LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println(now.plusMonths(1));
        System.out.println(now.plusMonths(1).minusDays(1));

        LocalDateTime agora = LocalDateTime.now();
        System.out.println("=======");
        System.out.println(agora);

        LocalDateTime hojeAoMeioDia = LocalDate.now().atTime(12, 0);
        System.out.println("=======");
        System.out.println(hojeAoMeioDia);

        ZonedDateTime dataComHoraETimezone =
                hojeAoMeioDia.atZone(ZoneId.of("America/Sao_Paulo"));

        System.out.println("=======");
        System.out.println(dataComHoraETimezone);

        LocalDate date = LocalDate.of(2014, 12, 25);

        LocalDate hoje = LocalDate.now();
        LocalDate amanha = LocalDate.now().plusDays(1);
        System.out.println("=======");

        System.out.println(hoje.isBefore(amanha));
        System.out.println(hoje.isAfter(amanha));
        System.out.println(hoje.isEqual(amanha));



        ZonedDateTime tokyo = ZonedDateTime
                .of(2011, 5, 2, 10, 30, 0, 0, ZoneId.of("Asia/Tokyo"));
        ZonedDateTime saoPaulo = ZonedDateTime
                .of(2011, 5, 2, 10, 30, 0, 0, ZoneId.of("America/Sao_Paulo"));

        System.out.println("=======");

        System.out.println(tokyo.isEqual(saoPaulo));


        tokyo = tokyo.plusHours(12);
        System.out.println(tokyo.isEqual(saoPaulo));

        System.out.println("=======");
        System.out.println(LocalDate.of(2014, 12, 25));
        System.out.println(LocalDate.of(2014, Month.DECEMBER, 25));

        System.out.println("=======");
        System.out.println(Month.DECEMBER.firstMonthOfQuarter());
        System.out.println(Month.DECEMBER.plus(2));

        Locale pt = new Locale("pt");
        System.out.println(Month.DECEMBER
                .getDisplayName(TextStyle.FULL, pt));
        System.out.println(Month.DECEMBER
                .getDisplayName(TextStyle.SHORT, pt));

        DayOfWeek day = DayOfWeek.MONDAY.minus(3);
        System.out.println(day);

        Calendar agora4 = Calendar.getInstance();
        Calendar outraData = Calendar.getInstance();
        outraData.set(1988, Calendar.JANUARY, 25);
        long diferenca = agora4.getTimeInMillis() - outraData.getTimeInMillis();
        long milissegundosDeUmDia = 1000 * 60 * 60 * 24;
        long dias = diferenca / milissegundosDeUmDia;

        LocalDate agora2 = LocalDate.now();
        LocalDate janeiroDe85 = LocalDate.of(1985, Month.JANUARY, 25);
        long between = ChronoUnit.DAYS.between(janeiroDe85, agora2);


        LocalDateTime start = LocalDateTime.now();
        //Metodo Demorado que eu quero saber a execucao
        LocalDateTime finish = LocalDateTime.now();
        long between1 = ChronoUnit.MILLIS.between(start, finish);


        LocalDate agora3 = LocalDate.now();
        LocalDate janeiroDe88 = LocalDate.of(1988, Month.JANUARY, 25);
        Period periodo = Period.between(janeiroDe88, agora3);
        System.out.printf("%s dias, %s meses e %s anos",
                periodo.getDays(), periodo.getMonths(), periodo.getYears());

        System.out.println("=====================");
        Calendar instante = Calendar.getInstance();
        instante.set(2014, Calendar.FEBRUARY, 30);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        System.out.println(dateFormat.format(instante.getTime()));


        //LocalDate.of(2014, Month.FEBRUARY, 30);
        try{
            LocalDateTime horaInvalida = LocalDate.now().atTime(25, 0);
        }catch (DateTimeException ex){

        }



    }
}
