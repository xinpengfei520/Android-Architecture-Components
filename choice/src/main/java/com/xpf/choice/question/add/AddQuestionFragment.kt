package com.xpf.choice.question.add

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.*
import com.xpf.choice.ChoiceApplication
import com.xpf.choice.R
import com.xpf.choice.model.Question
import kotlinx.android.synthetic.main.fragment_add_question.*

class AddQuestionFragment : Fragment() {

    companion object {
        fun newInstance(): Fragment {
            return AddQuestionFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_add_question, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.add_question_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.save_question -> {
                val title = question_title.editText?.text.toString()
                val description = question_description.editText?.text.toString()
                val question = Question(title = title, description = description)
                val handler = Handler()
                Thread {
                    ChoiceApplication.db?.questionDao()?.insert(question)
                    handler.post {
                        activity?.finish()
                    }
                }.start()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}