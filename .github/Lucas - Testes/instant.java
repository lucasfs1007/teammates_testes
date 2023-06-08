public static String formatInstant(Instant instant, String timeZone, String pattern) {
        if (instant == null || timeZone == null || pattern == null) {
        return "";
        }
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of(timeZone));
        String processedPattern = pattern;
        if (zonedDateTime.getHour() == 12 && zonedDateTime.getMinute() == 0) {
        processedPattern = pattern.replace("a", "'NOON'");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(processedPattern);
        return zonedDateTime.format(formatter);
        }

/**
 * Gets an Instant which is adjusted for midnight time (23:59 and 00:00) at the specified time zone.
 * The direction of adjustment (23:59 to 00:00 or vice versa) is determined by {@code isForward} parameter.
 */