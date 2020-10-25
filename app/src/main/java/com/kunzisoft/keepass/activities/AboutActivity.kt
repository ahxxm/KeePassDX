/*
 * Copyright 2019 Jeremy Jamet / Kunzisoft.
 *     
 * This file is part of KeePassDX.
 *
 *  KeePassDX is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  KeePassDX is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with KeePassDX.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.kunzisoft.keepass.activities

import android.content.pm.PackageManager.NameNotFoundException
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.text.HtmlCompat
import com.kunzisoft.keepass.BuildConfig
import com.kunzisoft.keepass.R
import com.kunzisoft.keepass.activities.stylish.StylishActivity
import org.joda.time.DateTime

class AboutActivity : StylishActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_about)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = getString(R.string.about)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        var version = "version"
        val versionTextView = findViewById<TextView>(R.id.activity_about_version)
        versionTextView.text = version

        var build = "build"
        val buildTextView = findViewById<TextView>(R.id.activity_about_build)
        buildTextView.text = build

        findViewById<TextView>(R.id.activity_about_licence_text).apply {
            movementMethod = LinkMovementMethod.getInstance()
            text = HtmlCompat.fromHtml(getString(R.string.html_about_licence, DateTime().year),
                    HtmlCompat.FROM_HTML_MODE_LEGACY)
        }

        findViewById<TextView>(R.id.activity_about_contribution_text).apply {
            movementMethod = LinkMovementMethod.getInstance()
            text = HtmlCompat.fromHtml(getString(R.string.html_about_contribution),
                    HtmlCompat.FROM_HTML_MODE_LEGACY)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
