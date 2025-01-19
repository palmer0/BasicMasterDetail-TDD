package es.ulpgc.eite.da.basic_master_detail;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@SuppressWarnings("ALL")
@LargeTest
@RunWith(AndroidJUnit4.class)
public class MasterDetailEspressoTests {

    @Rule
    public ActivityTestRule<CategoryListActivity> testRule =
        new ActivityTestRule<>(CategoryListActivity.class);

    @Test
    public void appTest() {

        // Scenario: Verify categories are displayed
        // GIVEN: I am on the Categories screen
        // THEN: I should see the categories "Electronics", "Books", and "Fashion"

        onView(new RecyclerViewMatcher(R.id.category_list_recycler)
            .atPositionOnView(0, R.id.category_name))
            .check(matches(withText("Electronics")));

        onView(new RecyclerViewMatcher(R.id.category_list_recycler)
            .atPositionOnView(1, R.id.category_name))
            .check(matches(withText("Books")));

        // Scenario: View products for a category
        // GIVEN: I am on the Categories screen
        // WHEN: I click on the "Fashion" category
        // THEN: I should see the products "T-shirt" and "Jeans"

        ViewInteraction recyclerView1 =
            onView(new RecyclerViewMatcher(R.id.category_list_recycler)
                .atPositionOnView(2, R.id.category_name))
                .check(matches(withText("Fashion")));
        recyclerView1.perform(click());


        onView(new RecyclerViewMatcher(R.id.product_list_recycler)
            .atPositionOnView(0, R.id.product_name))
            .check(matches(withText("T-shirt")));

        onView(new RecyclerViewMatcher(R.id.product_list_recycler)
            .atPositionOnView(1, R.id.product_name))
            .check(matches(withText("Jeans")));


        pressBack();

        // Scenario: Verify navigation to another category
        // GIVEN: I am on the Categories screen
        // WHEN: I click on the "Electronics" category
        // THEN: I should see the products "Smartphone" and "Laptop"

        onView(new RecyclerViewMatcher(R.id.category_list_recycler)
            .atPositionOnView(0, R.id.category_name))
            .check(matches(withText("Electronics")));

        ViewInteraction recyclerView2 =
            onView(new RecyclerViewMatcher(R.id.category_list_recycler)
                .atPositionOnView(0, R.id.category_name))
                .check(matches(withText("Electronics")));
        recyclerView2.perform(click());


        onView(new RecyclerViewMatcher(R.id.product_list_recycler)
            .atPositionOnView(0, R.id.product_name))
            .check(matches(withText("Smartphone")));

        // Scenario: View product details
        // GIVEN: I am on the Products screen
        // WHEN: I click on the "Laptop" product
        // THEN: I should see the detailed description

        ViewInteraction recyclerView3 =
            onView(new RecyclerViewMatcher(R.id.product_list_recycler)
                .atPositionOnView(1, R.id.product_name))
                .check(matches(withText("Laptop")));
        recyclerView3.perform(click());


        ViewInteraction textView15 = onView(allOf(
            withId(R.id.product_description),
            isDisplayed()
        ));
        textView15.check(matches(withText(
            "High performance laptop for gaming and work"
        )));


        pressBack();

        // Scenario: Verify products remain after navigation
        // GIVEN: I am on the Products screen
        // WHEN: I press back to return to the Categories screen
        // THEN: I should see the "Electronics" and "Books" categories again

        onView(new RecyclerViewMatcher(R.id.product_list_recycler)
            .atPositionOnView(0, R.id.product_name))
            .check(matches(withText("Smartphone")));


        pressBack();


        onView(new RecyclerViewMatcher(R.id.category_list_recycler)
            .atPositionOnView(0, R.id.category_name))
            .check(matches(withText("Electronics")));

        onView(new RecyclerViewMatcher(R.id.category_list_recycler)
            .atPositionOnView(1, R.id.category_name))
            .check(matches(withText("Books")));
    }


}
