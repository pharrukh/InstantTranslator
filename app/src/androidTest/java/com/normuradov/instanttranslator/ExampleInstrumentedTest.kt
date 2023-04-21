package com.normuradov.instanttranslator

import androidx.compose.material.Surface
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.normuradov.instanttranslator.ui.theme.InstantTranslatorTheme

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Ignore
import org.junit.Rule
import java.text.NumberFormat

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
//@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
//    @Ignore
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            InstantTranslatorTheme {
                Surface() {
                    TipTimeScreen()
                }
            }
        }

        composeTestRule.onNodeWithText("Cost of Service")
            .performTextInput("10")

//        composeTestRule.onNodeWithText("Tip (%)")
//            .performTextInput("20")

        val expectedTip = NumberFormat.getCurrencyInstance().format(1.5)
        composeTestRule.onNodeWithText("Tip amount: $expectedTip").assertExists(
            "No node with this text was found."
        )

    }


//    @Test
//    fun useAppContext() {
//        // Context of the app under test.
//        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
//        assertEquals("com.normuradov.instanttranslator", appContext.packageName)
//    }
}