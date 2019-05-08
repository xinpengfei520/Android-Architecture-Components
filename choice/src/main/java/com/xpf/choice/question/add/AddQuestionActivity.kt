package com.xpf.choice.question.add

import android.support.v4.app.Fragment
import com.xpf.choice.SingleFragmentActivity

class AddQuestionActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        return AddQuestionFragment.newInstance()
    }
}
