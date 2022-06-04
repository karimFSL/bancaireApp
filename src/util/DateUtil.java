package util;

import java.text.Format;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil {

	/** The date pattern that is used for conversion. Change as you wish. */
	private static final String DATE_PATTERN = "dd.MM.yyyy";

	/** The date formatter. */
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

	public static Format format(String string) {
		if (string == null) {
			return null;
		}
		return DATE_FORMATTER.toFormat();
	}

	/**
	 * 
	 * @param dateString la date en type String
	 * 
	 * @return retorune la date sinon NULL si on peut pas covertir
	 */

	public static LocalDate parse(String dateString) {
		try {
			return DATE_FORMATTER.parse(dateString, LocalDate::from);
		} catch (DateTimeParseException e) {
			return null;
		}
	}

	/**
	 * Checks the String whether it is a valid date. verifie si le string est une
	 * date valide
	 * 
	 * @param dateString
	 * @return vrai si le String est une date valide
	 */
	public static boolean validDate(String dateString) {
		// Try to parse the String.
		return DateUtil.parse(dateString) != null;
	}
}