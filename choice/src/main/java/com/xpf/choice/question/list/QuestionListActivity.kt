package com.xpf.choice.question.list

import android.support.v4.app.Fragment
import com.xpf.choice.SingleFragmentActivity

class QuestionListActivity : SingleFragmentActivity() {
    
    override fun createFragment(): Fragment {
        return QuestionListFragment.newInstance()
    }
}
