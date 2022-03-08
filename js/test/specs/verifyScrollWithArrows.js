const HomePage = require('../pageobjects/home.page');
var assert = require('assert');

describe('Verifying scroll with arrow keys', () => {
    it('should scroll up and down the home page using arrow keys', async () => {
        await browser.maximizeWindow()
        await HomePage.open();

        // Scrolling to the bottom with down arrow key and verifying subscription
        await HomePage.pressDown();
        // Scrolls down to subscription title usin xpath
        await $('/html/body/footer/div[1]/div/div/div[2]/div/h2').isDisplayedInViewport();
        // Verifies subscription title
        const title = await HomePage.subscriptionTitle();
        await assert.equal(title, 'SUBSCRIPTION');

        //Scrolling to the top with up arrow key and verifying Full-Fledged practice website for Automation Engineers text
        await HomePage.pressUp();
        // Scrolls to top descrption using xpath
        await $('/html/body/section[1]/div/div/div/div/div/div[1]/div[1]/h2').isDisplayedInViewport();
        // Verifies top description text
        const topDesc = await HomePage.topDescriptionText();
        await assert.equal(topDesc, "Full-Fledged practice website for Automation Engineers");
    });
});