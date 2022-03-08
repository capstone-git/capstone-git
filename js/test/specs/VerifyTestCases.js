const HomePage = require('../pageobjects/home.page');
const TestCase = require('../pageobjects/testCase.page');
var assert = require('assert');

describe('Verifying Test Case Page', () => {
    it('should navigate to test case page', async () => {
        await HomePage.open();

        // clicks on test cases button
        await HomePage.testCases();
        // Verifies title
        const title = await TestCase.title();
        await assert.equal(title, 'TEST CASES');
    });
});