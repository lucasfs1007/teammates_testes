public static String formatInstant(Instant instant, String timeZone, String pattern) {
        if (instant == null || timeZone == null || pattern == null) {
            // tratamos agora como uma exceção e não uma string vazia para indicar o erro
        throw new IllegalArgumentException("Instant, timeZone, and pattern cannot be null");
        }

        try {
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of(timeZone));
        String processedPattern = pattern;
        //simplifica a comparação para agora olharmos o horário de 12:00 independente dos minutos
        if (zonedDateTime.toLocalTime().equals(LocalTime.NOON)) {
        processedPattern = pattern.replace("a", "'NOON'");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(processedPattern);
        return zonedDateTime.format(formatter);
            //criamos esse catch apenas para tratar eventuais erros que possam vir a acontecer
        } catch (DateTimeException e) {
        e.printStackTrace();
        return ""; //paralização do método
        }
        }
