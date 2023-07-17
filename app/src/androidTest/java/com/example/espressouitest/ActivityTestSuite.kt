package com.example.espressouitest

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainActivity::class,
    SecondaryActivity::class
)
class ActivityTestSuite