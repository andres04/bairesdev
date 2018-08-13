/*
 * Copyright 2018 Vandolf Estrellado
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pe.andres.bairesdev.ui.home.events.view

import android.app.Fragment

import pe.andres.bairesdev.inject.PerChildFragment
import pe.andres.bairesdev.ui.common.view.BaseChildFragmentModule
import pe.andres.bairesdev.ui.home.events.presenter.EventsPresenterModule

import javax.inject.Named

import dagger.Binds
import dagger.Module

@Module(includes = arrayOf(BaseChildFragmentModule::class, EventsPresenterModule::class))
abstract class EventsFragmentModule {

    @Binds
    @Named(BaseChildFragmentModule.CHILD_FRAGMENT)
    @PerChildFragment
    internal abstract fun fragment(eventsFragment: EventsFragment): Fragment

    @Binds
    @PerChildFragment
    internal abstract fun eventsView(eventsFragment: EventsFragment): EventsView
}
