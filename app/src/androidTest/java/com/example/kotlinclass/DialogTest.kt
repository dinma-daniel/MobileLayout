import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.kotlinclass.Details
import org.junit.Rule
import org.junit.Test

class DialogTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun dialogDisplays() {
        var dialogDisplayed = false

        composeTestRule.setContent {
            Details {
                dialogDisplayed = true
            }
        }

        composeTestRule.onNodeWithText("Confirmation").assertIsDisplayed()
        composeTestRule.onNodeWithText("Please conform that you want to Adopt this pet").assertIsDisplayed()
        composeTestRule.onNodeWithText("Confirm").performClick()
        composeTestRule.onNodeWithText("Cancel").performClick()

        assert(dialogDisplayed)
    }
}
