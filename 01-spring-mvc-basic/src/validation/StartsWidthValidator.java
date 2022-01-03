package validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartsWidthValidator implements ConstraintValidator<StartsWith, String> {

	private String[] prefixes;

	@Override
	public void initialize(StartsWith startsWidth) {
		this.prefixes = startsWidth.values();
	}

	@Override
	public boolean isValid(String input, ConstraintValidatorContext context) {
		if (input == null) {
			return false;
		}
		for (String prefix: prefixes) {
			if (input.startsWith(prefix)) {
				return true;
			}
		}
		return false;
	}

}
