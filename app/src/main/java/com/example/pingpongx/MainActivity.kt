import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import com.example.pingpongx.Constants
import com.example.pingpongx.PlayerActivity
import com.example.pingpongx.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var playerOneScore = 0
    private var playerTwoScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("ESTADO", "onCreate")

        if(savedInstanceState != null) {
            playerOneScore = savedInstanceState.getInt("playerOneScore", 0)
            playerTwoScore = savedInstanceState.getInt("playerTwoScore", 0)
            setUpScorePlayerOne()
            setUpScorePlayerTwo()
        }

        setUpPlayers()
        setUpListeners()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("playerOneScore", playerOneScore)
        outState.putInt("playerTwoScore", playerTwoScore)
    }

    private fun setUpListeners() {
        btPlayerOneScore.setOnClickListener {
            playerOneScore++
            setUpScorePlayerOne()
        }

        btPlayerTwoScore.setOnClickListener {
            playerTwoScore++
            setUpScorePlayerTwo()
        }

        btRevenge.setOnClickListener {
            rematch()
        }

        btFinishMatch.setOnClickListener {
            val telaPlayer = Intent(this, PlayerActivity::class.java)
            telaPlayer.putExtra("rematch", true)
            startActivityForResult(telaPlayer, 1)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        intent = data
        setUpPlayers()
        rematch()
    }



    private fun setUpScorePlayerOne() {
        tvPlayerOneScore.text = playerOneScore.toString()
    }

    private fun setUpScorePlayerTwo() {
        tvPlayerTwoScore.text = playerTwoScore.toString()
    }

    private fun setUpPlayers() {
        tvPlayerOneName.text = intent.getStringExtra(Constants.KEY_EXTRA_PLAYER_1)
        tvPlayerTwoName.text = intent.getStringExtra(Constants.KEY_EXTRA_PLAYER_2)
    }

    private fun rematch() {
        playerOneScore = 0
        playerTwoScore = 0
        setUpScorePlayerOne()
        setUpScorePlayerTwo()
    }


    override fun onStart() {
        super.onStart()
        Log.d("ESTADO", "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ESTADO", "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ESTADO", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ESTADO", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ESTADO", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ESTADO", "onDestroy")
    }
}