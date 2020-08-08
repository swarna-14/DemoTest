package FunctionalTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectDay {

	static WebDriver browser;
	public static void SelectDayFromMultiDateCalendar(String day)
			throws InterruptedException {

		// We are using a special XPath style to select the day of current
		// month.
		// It will ignore the previous or next month day and pick the correct
		// one.
		By calendarXpath = By
				.xpath("//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()='"
						+ day + "']");
		browser.findElement(calendarXpath).click();

		// Intentional pause for 2 seconds.
		Thread.sleep(2000);
	}
}
