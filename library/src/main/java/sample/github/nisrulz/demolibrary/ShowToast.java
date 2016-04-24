/*
 * Copyright (C) 2016 Nishant Srivastava
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.github.nisrulz.demolibrary;

import android.content.Context;
import android.widget.Toast;

public class ShowToast {
    private static ShowToast ourInstance = new ShowToast();

    public static ShowToast getInstance() {
        return ourInstance;
    }

    private ShowToast() {
    }

    public void toast(Context context, String data) {
        Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
    }
}
