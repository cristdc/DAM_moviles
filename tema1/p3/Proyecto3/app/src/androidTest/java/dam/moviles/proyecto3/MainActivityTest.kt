package dam.moviles.proyecto3

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.isNotEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    lateinit var emulador : ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        //el emulador se crea siempre en setup para que cada test tenga su propio emulador
        emulador = launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        emulador.close()
    }

    @Test
    fun test1(){
        //al iniciar chr 00:00
        onView(withId(R.id.chrReloj))
            .check(matches(withText("00:00")))
    }
    @Test
    fun test2(){
        onView(withId(R.id.btnInicio))
            .check(matches(isEnabled()))
        onView(withId(R.id.btnStop))
            .check(matches(isNotEnabled()))
    }
    @Test
    fun test3(){
        onView(withId(R.id.btnInicio))
            .perform(click())
            .check(matches(isNotEnabled()))
    }
    @Test
    fun test4(){
        onView(withId(R.id.btnInicio))
            .perform(click())
        Thread.sleep(5000)
        emulador.recreate()
        onView(withId(R.id.chrReloj))
            .check(matches(withText("00:05")))
    }

}