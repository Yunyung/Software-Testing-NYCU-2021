import angr #the main framework
from angrutils import * # for cfg
import bingraphvis # for cfg

proj = angr.Project("./give_me_password", load_options={'auto_load_libs':False})
main = proj.loader.main_object.get_symbol("main")
start_state = proj.factory.blank_state(addr=main.rebased_addr)
cfg = proj.analyses.CFGEmulated(fail_fast=True, starts=[main.rebased_addr], initial_state=start_state)
plot_cfg(cfg, "Lab9_cfg_full", asminst=True, remove_imports=True, remove_path_terminator=True)  



