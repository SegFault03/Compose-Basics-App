package com.example.unscramble.ui.test

import com.example.unscramble.data.MAX_NO_OF_WORDS
import com.example.unscramble.data.SCORE_INCREASE
import com.example.unscramble.data.getUnscrambledWord
import com.example.unscramble.ui.GameViewModel
import org.junit.Test
import org.junit.Assert.*

class GameViewModelTest {
    private val viewModel = GameViewModel()
    @Test
    fun gameViewModel_CorrectWordGuessed_ScoreUpdatedAndErrorFlagUnsetWordCountIncWordUpdated()  {
        var gameUiState = viewModel.uiState.value
        val prevWord = gameUiState.currentScrambledWord
        val prevWordCount = gameUiState.currentWordCount
        val correctWord = getUnscrambledWord(gameUiState.currentScrambledWord)
        viewModel.updateUserGuess(correctWord)
        viewModel.checkUserGuess()
        gameUiState = viewModel.uiState.value
        assertFalse(gameUiState.isGuessedWordWrong)
        assertEquals(SCORE_INCREASE,gameUiState.score)
        assertNotEquals(prevWord, gameUiState.currentScrambledWord)
        assertEquals(prevWordCount+1, gameUiState.currentWordCount)
    }

    @Test
    fun gameViewModel_IncorrectWordGuessed_ScoreNotUpdatedErrorFlagSetWordCountSameWordNotUpdated(){
        var gameUiState = viewModel.uiState.value
        val prevScore = gameUiState.score
        val prevWord = gameUiState.currentScrambledWord
        val prevWordCount = gameUiState.currentWordCount
        val incorrectWord = "No"
        viewModel.updateUserGuess(incorrectWord)
        viewModel.checkUserGuess()
        gameUiState = viewModel.uiState.value
        assertTrue(gameUiState.isGuessedWordWrong)
        assertEquals(prevScore,gameUiState.score)
        assertEquals(prevWord, gameUiState.currentScrambledWord)
        assertEquals(prevWordCount, gameUiState.currentWordCount)
    }


    @Test
    fun gameViewModel_Initialization_InitialStateLoadedCorrectly(){
        val gameUiState = viewModel.uiState.value
        assertFalse(gameUiState.isGameOver)
        assertFalse(gameUiState.isGuessedWordWrong)
        assertEquals(0,gameUiState.score)
        assertEquals(1,gameUiState.currentWordCount)
    }

    @Test
    fun gameViewModel_UserSkipsAWord_WordCountNoChangeScoreNoChangeUpdateCurrentWord(){
        var gameUiState = viewModel.uiState.value
        val prevWord = gameUiState.currentScrambledWord
        val prevWordCount = gameUiState.currentWordCount
        val prevScore = gameUiState.score
        viewModel.skipWord()
        gameUiState = viewModel.uiState.value
        assertNotEquals(prevWord, gameUiState.currentScrambledWord)
        assertEquals(prevWordCount+1, gameUiState.currentWordCount)
        assertEquals(prevScore, gameUiState.score)
    }

    @Test
    fun gameViewModel_GameFinished_FinalStateSetCorrectly(){
        var gameUiState = viewModel.uiState.value
        repeat(MAX_NO_OF_WORDS){
            val correctWord = getUnscrambledWord(gameUiState.currentScrambledWord)
            viewModel.updateUserGuess(correctWord)
            viewModel.checkUserGuess()
            gameUiState.currentScrambledWord
            gameUiState.currentWordCount
            val prevScore = gameUiState.score
            gameUiState = viewModel.uiState.value
            assertFalse(gameUiState.isGuessedWordWrong)
            assertEquals(prevScore + SCORE_INCREASE,gameUiState.score)
        }
        assertEquals(MAX_NO_OF_WORDS, gameUiState.currentWordCount)
        assertTrue(gameUiState.isGameOver)
    }
}