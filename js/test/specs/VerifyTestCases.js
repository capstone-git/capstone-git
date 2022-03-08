const HomePage = require('../pageobjects/home.page');
const TestCase = require('../pageobjects/testCase.page');
var assert = require('assert');

describe('Verifying Test Case Page', () => {
    it('should navigate to test case page', async () => {
        await HomePage.open();
        await HomePage.testCases();

        const title = await TestCase.title();
        assert.equal(title, 'TEST CASES');
    });
});