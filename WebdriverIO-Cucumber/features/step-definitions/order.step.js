const { Given, When, Then } = require('@wdio/cucumber-framework');

const MenuPage = require('../pageobjects/menu.page');
const HomePage = require('../pageobjects/home.page');

Given(/^I am on the menu page$/, async () => {
    await MenuPage.open();
    await browser.pause(1000);
});

When(/^I click ADD TO ORDER button$/, async () => {
    await MenuPage.btnAddOrder.click();
    await browser.pause(1000);
});

Then(/^I should see a pop up menu with an item added to the cart$/, async () => {
    const orderName = await $('span[class=orderName]');
    await expect(orderName).toExist();
});



When(/^I click the SORT BY button, pick LIKES, click APPLY FILTERS button$/, async () => {
    await MenuPage.sorting.click();
    await browser.pause(1000);
    await MenuPage.sorting_1.click();
    await browser.pause(1000);
    await MenuPage.btnSubmitOrder.click();
    await browser.pause(1000);
});


Then(/^I should see the menu page with items sorted by Likes$/, async () => {
    const first = await $('app-own-menu-card-details>div:nth-child(2)>h3');
    await expect(first).toHaveText('BEER');
});




Given(/^I am on the home page and log in as user0$/, async () => {
    await HomePage.open();
    await HomePage.btnLogin.click();
    await HomePage.login('user0', 'password');
    await HomePage.btnSubmitLogin.click();
    await browser.pause(1000);
});

When(/^I click Set up two factor authentication$/, async () => {
    await HomePage.btnAccount.click();
    await HomePage.btnSetting.click();
    await browser.pause(1000);
    await HomePage.btnSwitch.click();
    await browser.pause(1000);
});

Then(/^I should see a QR code$/, async () => {
    const qrCode = await $('img[class="mat-card-image.ng-star-inserted"]');
    await expect(qrCode).toExist();
});